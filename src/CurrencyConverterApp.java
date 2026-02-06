public class CurrencyConverterApp {
    
    private ExchangeRateService exchangeRateService;
    private MenuManager menuManager;
    
    public CurrencyConverterApp() {
        this.exchangeRateService = new ExchangeRateService();
        this.menuManager = new MenuManager();
    }
    
    // Main application loop
    
    public void start() {
        menuManager.displayWelcome();
        
        boolean running = true;
        
        while (running) {
            menuManager.displayMenu();
            int choice = menuManager.getMenuChoice();
            
            if (choice == 11) {
                running = false;
                menuManager.displayGoodbye();
            } else if (choice >= 1 && choice <= 10) {
                processConversion(choice);
            } else {
                menuManager.displayInvalidChoice();
            }
        }
        
        menuManager.close();
    }
    
   //Process a currency conversion based on user's choice
    private void processConversion(int choice) {
        // Get the conversion option
        MenuManager.ConversionOption option = menuManager.getConversionOption(choice);
        
        if (option == null) {
            menuManager.displayInvalidChoice();
            return;
        }
        
        // Get amount from user
        double amount = menuManager.getAmount();
        
        if (amount < 0) {
            menuManager.displayError("Valor inválido! Digite um número positivo.");
            return;
        }
        
        // Perform conversion
        try {
            ConversionResult result = exchangeRateService.convert(
                option.getFromCurrency(),
                option.getToCurrency(),
                amount
            );
            
            result.displayResult();
            
        } catch (Exception e) {
            handleConversionError(e);
        }
    }
    
    // Handle errors that occur during conversion
     
    private void handleConversionError(Exception e) {
        String errorMessage;
        
        if (e.getMessage().contains("API")) {
            errorMessage = "Erro ao buscar taxa de câmbio. Verifique sua API key e conexão.";
        } else if (e.getMessage().contains("Moeda não suportada")) {
            errorMessage = "Moeda não suportada pela API.";
        } else {
            errorMessage = "Erro desconhecido: " + e.getMessage();
        }
        
        menuManager.displayError(errorMessage);
    }
    
    // Main entry point of the application
    
    public static void main(String[] args) {
        CurrencyConverterApp app = new CurrencyConverterApp();
        app.start();
    }
}
