public class ConversionResult {
    private Currency fromCurrency;
    private Currency toCurrency;
    private double amount;
    private double convertedAmount;
    private double exchangeRate;
    
    public ConversionResult(Currency fromCurrency, Currency toCurrency, 
                           double amount, double convertedAmount, double exchangeRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.exchangeRate = exchangeRate;
    }
    
    public Currency getFromCurrency() {
        return fromCurrency;
    }
    
    public Currency getToCurrency() {
        return toCurrency;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public double getConvertedAmount() {
        return convertedAmount;
    }
    
    public double getExchangeRate() {
        return exchangeRate;
    }
    
    public void displayResult() {
        System.out.println("\n-------------------------------------------");
        System.out.printf("%.2f %s = %.2f %s%n", 
                         amount, fromCurrency.getCode(), 
                         convertedAmount, toCurrency.getCode());
        System.out.printf("Taxa de câmbio: 1 %s = %.4f %s%n", 
                         fromCurrency.getCode(), exchangeRate, toCurrency.getCode());
        System.out.println("-------------------------------------------\n");
    }
}
