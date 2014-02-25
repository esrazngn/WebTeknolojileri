package com.odev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sada {
public static void main(String args[]){
	final HashMap<String, Double> yemek = new HashMap<String, Double>();			
    yemek.put("Bolu Köfte 9.90 TL",9.90);
    yemek.put("Kasap Köfte 9.90 TL",9.90);
    yemek.put("Tavuk Pirzola 9.50 TL",9.50);
    yemek.put("Tavuk Þiþ 9.50 TL",9.50);
    yemek.put("Kuzu Pirzola 15.00 TL",15.0);
    yemek.put("Kuzu Þiþ 15.00 TL",15.0);
    yemek.put("Dana Biftek 15.00 TL",15.0);
    yemek.put("Dana Sadra 15.00 TL",15.0);
    yemek.put("Et Þiþ 15.00 TL",15.0);
    yemek.put("Bolu Special Izgara 40.00 TL" ,40.0);
	final List<String> yem = new ArrayList<String>(yemek.keySet());
    System.out.println(yem);
}
}
