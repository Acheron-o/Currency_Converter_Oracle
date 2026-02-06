import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateService {
    private static final String API_KEY = "YOUR_API_KEY_HERE"; // Replace with your actual API key
    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";
    
    private HttpClient client;
    private Gson gson;
    
    public ExchangeRateService() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }
    
    /**
     * Fetches the exchange rate between two currencies from the API
     * @param fromCurrency Source currency code
     * @param toCurrency Target currency code
     * @return Exchange rate as a double
     * @throws IOException If there's a network error or API error
     * @throws InterruptedException If the request is interrupted
     */
    public double getExchangeRate(String fromCurrency, String toCurrency) 
            throws IOException, InterruptedException {
        
        String url = API_BASE_URL + fromCurrency;
        
        // Build HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        
        // Send request and get response
        HttpResponse<String> response = client.send(request, 
                                                     HttpResponse.BodyHandlers.ofString());
        
        // Validate HTTP status code
        if (response.statusCode() != 200) {
            throw new IOException("API retornou código de erro: " + response.statusCode());
        }
        
        // Parse JSON response
        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
        
        // Validate API response
        String result = jsonResponse.get("result").getAsString();
        if (!result.equals("success")) {
            String errorType = jsonResponse.has("error-type") ? 
                             jsonResponse.get("error-type").getAsString() : "Unknown error";
            throw new IOException("Erro na API: " + errorType);
        }
        
        // Extract and return the conversion rate
        JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
        
        if (!conversionRates.has(toCurrency)) {
            throw new IOException("Moeda não suportada: " + toCurrency);
        }
        
        return conversionRates.get(toCurrency).getAsDouble();
    }
    
    /**
     * Converts an amount from one currency to another
     * @param fromCurrency Source currency
     * @param toCurrency Target currency
     * @param amount Amount to convert
     * @return ConversionResult object with all conversion details
     * @throws IOException If there's an API error
     * @throws InterruptedException If the request is interrupted
     */
    public ConversionResult convert(Currency fromCurrency, Currency toCurrency, double amount) 
            throws IOException, InterruptedException {
        
        double rate = getExchangeRate(fromCurrency.getCode(), toCurrency.getCode());
        double convertedAmount = amount * rate;
        
        return new ConversionResult(fromCurrency, toCurrency, amount, convertedAmount, rate);
    }
}
