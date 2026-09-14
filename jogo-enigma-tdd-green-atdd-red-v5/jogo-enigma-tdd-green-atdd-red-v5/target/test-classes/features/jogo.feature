# language: pt
Funcionalidade: Validação e Classificação de Risco de Modelos de IA
  Como um gestor de governança da QSOFT
  Eu quero garantir que as métricas de risco dos algoritmos sejam consistentes
  Para automatizar a classificação de criticidade dos modelos

  # BDD 1 (Responsável: Pedro)
  Cenário: Impedir registro de pontuação de risco negativa
    Dado um novo modelo de IA chamado "Algoritmo de Crédito"
    Quando eu tento registrar a sua pontuação de risco como -5,0
    Então o sistema deve recusar o registro lançando uma exceção
    E o modelo não deve ser salvo

  # BDD 2 (Responsável: Julia)
  Cenário: Classificar modelo automaticamente como Alto Risco
    Dado um modelo de IA chamado "Reconhecimento Facial"
    Quando a sua pontuação de risco for definida como 85,0
    Então o sistema deve classificá-lo como um modelo de Alto Risco

  # BDD 3 (Responsável: Pablo)
  Cenário: Classificar modelo com Risco Aceitável
    Dado um modelo de IA chamado "Chatbot de Atendimento"
    Quando a sua pontuação de risco for definida como 50,0
    Então o sistema deve retornar que ele não é de Alto Risco

  # BDD 4 (Responsável: Gustavo)
  Cenário: Impedir o cadastro de um modelo sem nome
    Dado que estou mapeando uma nova inteligência artificial no QAI Control
    Quando eu tento registrar o modelo deixando o nome em branco
    Então o sistema deve bloquear o cadastro lançando uma exceção