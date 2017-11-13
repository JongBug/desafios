package br.com.jonglee.RedditBot;

import java.util.Scanner;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Class main to bot
 * @author Jong.Lee
 * @version 1.0
 * @since 2017-11-11
 */
public class App 
{
	static Scanner in = new Scanner(System.in);
    public static void main( String[] args ) {
    	
    	int key;
    	
    	do {
        	System.out.println("Escolha qual parte quer executar:\n1- Parte 1 (CLI Simples) \n2- Parte2 (Inicializar aplicação do bot)");
        	key = in.nextInt();
        	
        	if (key == 1) {
        		parteUm();
        	} 
        	else if (key ==2) {
        		parteDois();
        	} else {
        		System.out.println("Tchau tchau");
        		key = 3;
        	}
        	
    	} while (key==3);

    }
    
    public static void parteUm () {
		String listSubreddits;
		do {
    		System.out.println("Insira uma lista com nomes de subreddits separados por ponto-e-vírgula(;). Ex: askreddit;worldnews;cats\n"
    				+ "Ou digite numero 0 para sair");
    		listSubreddits = in.next();
    		
        	if (!listSubreddits.equals("0")) {
        		if (listSubreddits.matches("([a-zA-Z0-9 ]+)([;]{1}[a-zA-Z0-9]+)*")) {
            		String threads[];
                	threads = listSubreddits.split(";");
                	RedditCollector reddit = new RedditCollector();
                	for (int i = 0; i < threads.length; i++) {
                		if(!reddit.collectData(threads[i]).isEmpty()) {
    	            		System.out.println(reddit.collectData(threads[i]).toString()
    	    				.replace("[", "").replace("]", "").replace(",", ""));
                		} else {
                			System.out.println("Nenhuma thread bombando em subreddit: " + threads[i]);
                		}
                	} 
        		} else {
        			System.out.println("Formato inválido, utilizar nomes de subreddits separados por ponto-e-vírgula(;). Ex: askreddit;worldnews;cats\n");
        		}

        	} else {
        		System.out.println("Tchau tchau");
        	}
        	
		} while (!listSubreddits.equals("0"));
    }
    
    public static void parteDois() {
    	System.out.println("Aplicação rodando, acesse via Telegram");
		System.out.println("Para desativar aperta as teclas \"ctrl+c\"");
    	ApiContextInitializer.init();
    	TelegramBotsApi botsApi = new TelegramBotsApi();
    	
        try {
            botsApi.registerBot(new JongRedditBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
