package com.odev;

import java.io.*;
import java.util.*;

public class Order {
    
    String kind;
    String with;
    int quantity;

    Order(String thekind) {
	kind = thekind;
	quantity = 1; // default quantity
    }

    Order(String thekind, String withwhat) {
	kind = thekind + withwhat;
	quantity = 1; // default quantity
    }    

    String getName() {
	if (with == null) 
	    return kind;
	return kind + " with " + with;
    }

    int getQuantity() {
	return quantity;
    }

    void setQuantity(int n) {
	quantity = n;
    }
}
