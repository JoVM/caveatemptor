package com.amudhan.caveatemptor.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomAlphaGenerator {
	final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWabcdefghijklmnopqrstuv";
	final String lexiconWithNumbers = "ABCDEFGHIJKLMNOPQRSTUVWabcdefghijklmnopqrstuv0123456789";
	final java.util.Random rand = new java.util.Random();
	public String randomString(){
		StringBuilder builder = new StringBuilder();
		if(builder !=null){
			int length = rand.nextInt(5)+5;
			for(int i=0;i<length;i++){
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			}
		}
		return builder.toString();
	}
	public int randomInt(int min, int max){
		return ThreadLocalRandom.current().nextInt(min, max+1);
	}
	public String randomNumbersOfDigits(int digits){
		StringBuilder builder = new StringBuilder();
		if(builder !=null){
			for(int i=0;i<digits;i++){
				builder.append(rand.nextInt(10));
			}
		}
		return builder.toString();
	}
	public String randomAlpha(){
		StringBuilder builder = new StringBuilder();
		if(builder !=null){
			int length = rand.nextInt(5)+5;
			for(int i=0;i<length;i++){
				builder.append(lexiconWithNumbers.charAt(rand.nextInt(lexiconWithNumbers.length())));
			}
		}
		return builder.toString();
	}
}
