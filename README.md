# Conversor de Moedas - Currency Convert

![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)er (OOP)


## 📋 Descrição
Conversor de moedas em tempo real utilizando a API ExchangeRate-API.com
Desenvolvido em Java com **arquitetura orientada a objetos** e interface de console interativa.

## 🏗️ Arquitetura (OOP)

### Classes e Responsabilidades:

1. **Currency.java** (Modelo)
   - Representa uma moeda (código e nome)
   - Encapsula dados da moeda

2. **ConversionResult.java** (Modelo)
   - Armazena resultado de uma conversão
   - Responsável por exibir o resultado formatado

3. **ExchangeRateService.java** (Serviço)
   - Comunica com a API ExchangeRate
   - Realiza conversões de moeda
   - Trata erros de API

4. **MenuManager.java** (Interface/UI)
   - Gerencia interação com usuário
   - Exibe menu e captura entrada
   - Contém opções de conversão disponíveis

5. **CurrencyConverterApp.java** (Controlador/Main)
   - Coordena toda a aplicação
   - Loop principal do programa
   - Processa conversões

### Princípios OOP Aplicados:
- ✅ **Encapsulamento**: Dados privados com getters/setters
- ✅ **Separação de responsabilidades**: Cada classe tem um propósito único
- ✅ **Coesão**: Classes focadas em uma única funcionalidade
- ✅ **Baixo acoplamento**: Classes independentes e reutilizáveis

## 🚀 Funcionalidades
- 10 opções de conversão de moedas
- Taxas de câmbio em tempo real via API
- Interface textual intuitiva em português
- Tratamento robusto de erros
- Validação de entrada do usuário

## 💱 Moedas Suportadas
- BRL (Real Brasileiro)
- USD (Dólar Americano)
- EUR (Euro)
- CHF (Franco Suíço)
- CNY (Yuan Chinês)
- CAD (Dólar Canadense)

## 🛠️ Tecnologias Utilizadas
- Java 11+
- HttpClient (requisições HTTP)
- Gson (parsing JSON)
- ExchangeRate-API
- Arquitetura OOP (Model-Service-UI)

## 📦 Como Executar

### Pré-requisitos
- Java JDK 11 ou superior instalado
- Conexão com a internet
- API key da ExchangeRate-API (gratuita)

### Passo 1: Obter API Key
1. Acesse https://www.exchangerate-api.com/
2. Crie uma conta gratuita
3. Copie sua API key

### Passo 2: Configurar o Projeto
1. Abra o arquivo `ExchangeRateService.java`
2. Na linha 11, substitua `YOUR_API_KEY_HERE` pela sua API key:
   ```java
   private static final String API_KEY = "sua_api_key_aqui";
   ```

### Passo 3: Baixar Gson Library
Baixe o arquivo JAR do Gson:
- Link direto: https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar
- Salve na mesma pasta dos arquivos .java

### Passo 4: Compilar
```bash
javac -cp .:gson-2.10.1.jar *.java
```

**Windows:**
```bash
javac -cp .;gson-2.10.1.jar *.java
```

### Passo 5: Executar
```bash
java -cp .:gson-2.10.1.jar CurrencyConverterApp
```

**Windows:**
```bash
java -cp .;gson-2.10.1.jar CurrencyConverterApp
```

## 🎯 Como Usar

1. Execute o programa: `java -cp .:gson-2.10.1.jar CurrencyConverterApp`
2. Escolha uma opção do menu (1-10)
3. Digite o valor a converter
4. Veja o resultado com a taxa de câmbio atual
5. Escolha opção 11 para sair

## 📝 Exemplo de Uso

```
===========================================
   BEM-VINDO AO CONVERSOR DE MOEDAS
===========================================

Escolha uma conversão:
 1) BRL (Real Brasileiro) → USD (Dólar Americano)
 2) USD (Dólar Americano) → BRL (Real Brasileiro)
 3) BRL (Real Brasileiro) → EUR (Euro)
 ...
11) Sair

Digite sua escolha: 1

Digite o valor a converter: 100

-------------------------------------------
100.00 BRL = 20.15 USD
Taxa de câmbio: 1 BRL = 0.2015 USD
-------------------------------------------
```

## ⚠️ Tratamento de Erros

O programa trata:
- ❌ Entrada inválida do usuário (letras, números negativos)
- ❌ Falhas de conexão com a API
- ❌ Erros na resposta da API (API key inválida, limite excedido)
- ❌ Valores negativos ou inválidos
- ❌ Moedas não suportadas

## 📚 Estrutura do Código

```
Currency Converter/
│
├── Currency.java              # Modelo: Representa uma moeda
├── ConversionResult.java      # Modelo: Resultado da conversão
├── ExchangeRateService.java   # Serviço: API communication
├── MenuManager.java           # UI: Interface com usuário
└── CurrencyConverterApp.java  # Main: Controla a aplicação
```
## 📄 Licença
MIT - Projeto educacional - Oracle Next Education (ONE)

---

**Desenvolvido para o desafio de Conversor de Moedas**  
**Oracle Next Education - Alura**  
