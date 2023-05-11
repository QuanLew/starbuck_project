package com.example.springcashier.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "orders")
@Data
@RequiredArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String drink ;
    private String milk ;
    private String size ;
    private double total ;
    private String register ;
    private String status ;

    public String setRandDrink(){
        String DRINK_OPTIONS[] = {"Caffe Latte", "Caffe Americano", "Caffe Mocha", "Espresso", "Cappuccino" };
        List<String> list_drinks = Arrays.asList(DRINK_OPTIONS);
        Collections.shuffle(list_drinks);
        return list_drinks.get(0);
    }

    public String setRandMilk(){
        String MILK_OPTIONS[]  = {"Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk", "Soy Milk" };
        List<String> list_drinks = Arrays.asList(MILK_OPTIONS);
        Collections.shuffle(list_drinks);
        return list_drinks.get(0);
    }

    public String setRandSize(){
        String SIZE_OPTIONS[]  = {"Short", "Tall", "Grande", "Venti", "Your Own Cup" };
        List<String> list_drinks = Arrays.asList(SIZE_OPTIONS);
        Collections.shuffle(list_drinks);
        return list_drinks.get(0);
    }
    public static Order GetNewOrder() {
        Order o = new Order();
        String DRINK_OPTIONS[] = {"Caffe Latte", "Caffe Americano", "Caffe Mocha", "Espresso", "Cappuccino" };
        String MILK_OPTIONS[]  = {"Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk", "Soy Milk" };
        String SIZE_OPTIONS[]  = {"Short", "Tall", "Grande", "Venti", "Your Own Cup" };

        List<String> list_drinks = Arrays.asList(DRINK_OPTIONS);
        List<String> list_milks = Arrays.asList(MILK_OPTIONS);
        List<String> list_sizes = Arrays.asList(SIZE_OPTIONS);

        Collections.shuffle(list_drinks);
        Collections.shuffle(list_milks);
        Collections.shuffle(list_sizes);

        o.drink =  list_drinks.get(0);
        o.milk = list_milks.get(0);
        o.size = list_sizes.get(0);

        if(list_drinks.get(0) == "Caffe Latte"){
            if(list_sizes.get(0) == "Short" || list_sizes.get(0) == "Tall"){
                o.total = 2.95 ;
            }
            if(list_sizes.get(0) == "Grande"){
                o.total = 3.65;
            }if(list_sizes.get(0) == "Venti" || list_sizes.get(0) == "Your Own Cup"){
                o.total = 3.95;
            }
        }

        if(list_drinks.get(0) == "Caffe Americano"){
            if(list_sizes.get(0) == "Short" || list_sizes.get(0) == "Tall"){
                o.total = 2.25 ;
            }
            if(list_sizes.get(0) == "Grande"){
                o.total = 2.65;
            }if(list_sizes.get(0) == "Venti" || list_sizes.get(0) == "Your Own Cup"){
                o.total = 2.95;
            }
        }

        if(list_drinks.get(0) == "Caffe Mocha"){
            if(list_sizes.get(0) == "Short" || list_sizes.get(0) == "Tall"){
                o.total = 3.45 ;
            }
            if(list_sizes.get(0) == "Grande"){
                o.total = 4.15;
            }if(list_sizes.get(0) == "Venti" || list_sizes.get(0) == "Your Own Cup"){
                o.total = 4.45;
            }
        }

        if(list_drinks.get(0) == "Cappuccino"){
            if(list_sizes.get(0) == "Short" || list_sizes.get(0) == "Tall"){
                o.total = 2.95;
            }
            if(list_sizes.get(0) == "Grande"){
                o.total = 3.65;
            }if(list_sizes.get(0) == "Venti" || list_sizes.get(0) == "Your Own Cup"){
                o.total = 3.95;
            }
        }

        if(list_drinks.get(0) == "Espresso"){
            if(list_sizes.get(0) == "Short" ){
                o.total = 1.75;
            }
            if(list_sizes.get(0) == "Grande" || list_sizes.get(0) == "Tall" ||
                    list_sizes.get(0) == "Venti" || list_sizes.get(0) == "Your Own Cup"){
                o.total = 1.95;
            }
        }

    	o.status = "Ready for Payment" ;

    	return o ;
    }


}


/*

https://priceqube.com/menu-prices/%E2%98%95-starbucks

var DRINK_OPTIONS = [ "Caffe Latte", "Caffe Americano", "Caffe Mocha", "Espresso", "Cappuccino" ];
var MILK_OPTIONS  = [ "Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk", "Soy Milk" ];
var SIZE_OPTIONS  = [ "Short", "Tall", "Grande", "Venti", "Your Own Cup" ];

Caffè Latte
=============
tall 	$2.95
grande 	$3.65
venti 	$3.95 (Your Own Cup)

Caffè Americano
===============
tall 	$2.25
grande 	$2.65
venti 	$2.95 (Your Own Cup)

Caffè Mocha
=============
tall 	$3.45
grande 	$4.15
venti 	$4.45 (Your Own Cup)

Cappuccino
==========
tall 	$2.95
grande 	$3.65
venti 	$3.95 (Your Own Cup)

Espresso
========
short 	$1.75
tall 	$1.95

 */



