# Desafio 2: Crawlers

## Jong Hwa Lee
Contato: jhl1254@gmail.com

### Etapas para inicialização
1- Baixar o arquivo RedditApp.jar encontrado no diretório "desafios/crawlers/" </br>
2- Abrir o prompt de comando no local aonde se encontra o arquivo RedditApp.jar baixado</br>
3- Verificar a versão do java com o seguinte comando:
```
java -version
```
4- Caso o java não seja versão 1.8, é preciso instalar java 1.8</br>
5- Executar o seguinte comando no prompt:
```
java -cp RedditApp.jar br.com.jonglee.RedditBot.App
```
#### Uso para parte 1
6- Para parte 1 basta digitar a opção "1"</br>
7- Inserir lista com nomes de subreddits separados por ponto-e-vírgula (;). Ex: "askreddit;worldnews;cats"</br>
8- Aperte "0" para sair</br>

#### Uso para parte 2
6'- Para parte 2 basta digitar a opção "2"</br>
7'- Filtrar e selecionar usuário bot @JongRedditBot pelo aplicativo Telegram</br>
8'- Inicializar a conversa</br>
9'- Aperte "ctrl+c" para sair</br>

### Descrição
Parte do trabalho na IDwall inclui desenvolver *crawlers/scrapers* para coletar dados de websites.
Como nós nos divertimos trabalhando, às vezes trabalhamos para nos divertir!

O Reddit é quase como um fórum com milhares de categorias diferentes. Com a sua conta, você pode navegar por assuntos técnicos, ver fotos de gatinhos, discutir questões de filosofia, aprender alguns life hacks e ficar por dentro das notícias do mundo todo!

Subreddits são como fóruns dentro do Reddit e as postagens são chamadas *threads*.

Para quem gosta de gatos, há o subreddit ["/r/cats"](https://www.reddit.com/r/cats) com threads contendo fotos de gatos fofinhos.
Para *threads* sobre o Brasil, vale a pena visitar ["/r/brazil"](https://www.reddit.com/r/brazil) ou ainda ["/r/worldnews"](https://www.reddit.com/r/worldnews/).
Um dos maiores subreddits é o "/r/AskReddit".

Cada *thread* possui uma pontuação que, simplificando, aumenta com "up votes" (tipo um like) e é reduzida com "down votes".

Sua missão é encontrar e listar as *threads* que estão bombando no Reddit naquele momento!
Consideramos como bombando *threads* com 5000 pontos ou mais.

## Entrada
- Lista com nomes de subreddits separados por ponto-e-vírgula (`;`). Ex: "askreddit;worldnews;cats"

### Parte 1
Gerar e imprimir uma lista contendo número de upvotes, subreddit, título da thread, link para os comentários da thread, link da thread.
Essa parte pode ser um CLI simples, desde que a formatação da impressão fique legível.

### Parte 2
Construir um robô que nos envie essa lista via Telegram sempre que receber o comando `/NadaPraFazer [+ Lista de subrredits]` (ex.: `/NadaPraFazer programming;dogs;brazil`)


Qualquer método para coletar os dados é válido. Caso não saiba por onde começar, procure por SeleniumHQ (Java), PhantomJS (Javascript) e Scrapy (Python).
