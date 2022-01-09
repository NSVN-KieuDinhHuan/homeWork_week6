package com.company;

import java.lang.reflect.Array;
import java.security.PublicKey;

public class Main {

    public static void main(String[] args) {

        Product[] product = new Product[3];
        product[0] = new Product(1, "A", 1000, "descript 1");
        product[1] = new Product(2, "B", 2000, "descript 2");
        product[2] = new Product(3, "C", 3000, "descript 3");
        Product product4 = new Product(4, "D", 4000, "descript4");
        System.out.println("1.hiển thị sản phẩm");
        displayProduct(product);
        System.out.println("2.Thêm sản phẩm D  vao vi tri 2");
        Product[] newProduct = addProduct(product4, product, 2);
        displayProduct(newProduct);
        System.out.println("3.xóa sản pham A");
        Product[] newProduct2 = removeElementFromArray(product, 0);
        displayProduct(newProduct2);
        System.out.println("4.kiểm tra sản phẩm B có trong mảng không");
        Product findProduct01 = findProduct(newProduct2, "B");
        if (findProduct01.getName() == "") {
            System.out.println("không có sản phẩm trong mảng");
        } else {
            System.out.println("Sản phẩm cần tìm kiếm là \n" + findProduct01);
        }
        System.out.println("5.săp xếp từ A đên Z");
        Product[] SortnewProduct2 = sorfProduct(newProduct);
        displayProduct(SortnewProduct2);
    }
    public static void displayProduct(Product[] arr){
        for(Product obj:arr){
            System.out.println(obj);
        }
    }
    public static Product[] addProduct(Product value,Product[] array,int index){
        Product[] newArray=new Product[array.length+1];
        for(int i=0;i<newArray.length;i++){
            if (i < index) {
                newArray[i] = array[i];
            } else if (i == index) {
                newArray[i] = value;
            } else {
                newArray[i] = array[i -1];
            }
        }
        return newArray;
    }

    public static Product[] removeElementFromArray(Product[] array, int index) {
        Product[] newArray = new Product[array.length - 1];
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = array[i];
            } else {
                newArray[i] = array[i + 1];
            }
        }
        return newArray;
    }

    public static Product findProduct(Product[] array, String productName) {
        Product checkproduct=new Product(0,"",0,"");
        for (Product element:array){
            if(element.getName()==productName){
                checkproduct=element;
                break;
            }
        }
     return checkproduct;
    }

    public static Product[] sorfProduct(Product[] array) {
        String[] productName= new String[array.length];
        for (int i=0;i< array.length;i++){
            productName[i] =array[i].getName();
        }
        java.util.Arrays.sort(productName);
        Product[] newProduct=new Product[array.length];
        for (int i=0;i< productName.length;i++){
           for(int j=0;j<productName.length;j++){
               if (productName[i]==array[j].getName()){
                   newProduct[i]=array[j];
               }
           }
        }

       return newProduct;
    }

}
