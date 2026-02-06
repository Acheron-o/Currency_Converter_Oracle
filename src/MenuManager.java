import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MenuManager {
    private Scanner scanner;
    private List<ConversionOption> conversionOptions;
    
    public MenuManager() {
        this.scanner = new Scanner(System.in);
        this.conversionOptions = initializeConversionOptions();
    }
    
    /**
     * Initialize all available conversion options
     */
    private List<ConversionOption> initializeConversionOptions() {
        List<ConversionOption> options = new ArrayList<>();
        
        Currency brl = new Currency("BRL", "Real Brasileiro");
        Currency usd = new Currency("USD", "Dólar Americano");
        Currency eur = new Currency("EUR", "Euro");
        Currency chf = new Currency("CHF", "Franco Suíço");
        Currency cny = new Currency("CNY", "Yuan Chinês");
        Currency cad = new Currency("CAD", "Dólar Canadense");
        
        options.add(new ConversionOption(1, brl, usd));
        options.add(new ConversionOption(2, usd, brl));
        options.add(new ConversionOption(3, brl, eur));
        options.add(new ConversionOption(4, eur, brl));
        options.add(new ConversionOption(5, brl, chf));
        options.add(new ConversionOption(6, chf, brl));
        options.add(new ConversionOption(7, brl, cny));
        options.add(new ConversionOption(8, cny, brl));
        options.add(new ConversionOption(9, brl, cad));
        options.add(new ConversionOption(10, cad, brl));
        
        return options;
    }
    
    /**
     * Display welcome message
     */
    public void displayWelcome() {
        System.out.println("===========================================");
        System.out.println("   BEM-VINDO AO CONVERSOR DE MOEDAS");
        System.out.println("===========================================\n");
    }
    
    /**
     * Display the main menu with all conversion options
     */
    public void displayMenu() {
        System.out.println("Escolha uma conversão:");
        
        for (ConversionOption option : conversionOptions) {
            System.out.printf("%2d) %s → %s%n", 
                            option.getNumber(),
                            option.getFromCurrency(),
                            option.getToCurrency());
        }
        
        System.out.println("11) Sair");
        System.out.print("\nDigite sua escolha: ");
    }
    
    /**
     * Get menu choice from user
     * @return User's menu choice (1-11)
     */
    public int getMenuChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            return choice;
        } catch (Exception e) {
            scanner.nextLine(); // Clear buffer
            return -1;
        }
    }
    
    /**
     * Get the amount to convert from user
     * @return Amount entered by user
     */
    public double getAmount() {
        System.out.print("\nDigite o valor a converter: ");
        try {
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer
            return amount;
        } catch (Exception e) {
            scanner.nextLine(); // Clear buffer
            return -1;
        }
    }
    
    /**
     * Get conversion option by menu number
     * @param choice Menu choice number
     * @return ConversionOption or null if invalid
     */
    public ConversionOption getConversionOption(int choice) {
        for (ConversionOption option : conversionOptions) {
            if (option.getNumber() == choice) {
                return option;
            }
        }
        return null;
    }
    
    /**
     * Display error message
     */
    public void displayError(String message) {
        System.out.println("\n❌ Erro: " + message + "\n");
    }
    
    /**
     * Display invalid choice message
     */
    public void displayInvalidChoice() {
        System.out.println("\n❌ Opção inválida! Tente novamente.\n");
    }
    
    /**
     * Display goodbye message
     */
    public void displayGoodbye() {
        System.out.println("\n✅ Obrigado por usar o Conversor de Moedas!");
        System.out.println("Até logo! 👋\n");
    }
    
    /**
     * Close the scanner
     */
    public void close() {
        scanner.close();
    }
    
    /**
     * Inner class to represent a conversion option
     */
    public static class ConversionOption {
        private int number;
        private Currency fromCurrency;
        private Currency toCurrency;
        
        public ConversionOption(int number, Currency fromCurrency, Currency toCurrency) {
            this.number = number;
            this.fromCurrency = fromCurrency;
            this.toCurrency = toCurrency;
        }
        
        public int getNumber() {
            return number;
        }
        
        public Currency getFromCurrency() {
            return fromCurrency;
        }
        
        public Currency getToCurrency() {
            return toCurrency;
        }
    }
}
