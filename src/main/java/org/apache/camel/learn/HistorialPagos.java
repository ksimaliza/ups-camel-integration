package org.apache.camel.learn;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",", skipFirstLine = true)
public class HistorialPagos {

    @DataField(pos = 1)
    private int id;
    @DataField(pos = 2)
    private int limitBal;
    @DataField(pos = 3)
    private int sex;
    @DataField(pos = 4)
    private int education;
    @DataField(pos = 5)
    private int marriage;
    @DataField(pos = 6)
    private int age;
    @DataField(pos = 7)
    private int pay0;
    @DataField(pos = 8)
    private int pay2;
    @DataField(pos = 9)
    private int pay3;
    @DataField(pos = 10)
    private int pay4;
    @DataField(pos = 11)
    private int pay5;
    @DataField(pos = 12)
    private int pay6;
    @DataField(pos = 13)
    private double bill1;
    @DataField(pos = 14)
    private double bill2;
    @DataField(pos = 15)
    private double bill3;
    @DataField(pos = 16)
    private double bill4;
    @DataField(pos = 17)
    private double bill5;
    @DataField(pos = 18)
    private double bill6;
    @DataField(pos = 19)
    private double payCurrent1;
    @DataField(pos = 20)
    private double payCurrent2;
    @DataField(pos = 21)
    private double payCurrent3;
    @DataField(pos = 22)
    private double payCurrent4;
    @DataField(pos = 23)
    private double payCurrent5;
    @DataField(pos = 24)
    private double payCurrent6;
    @DataField(pos = 25)
    private int defaultPaymentNextMonth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLimitBal() {
        return limitBal;
    }

    public void setLimitBal(int limitBal) {
        this.limitBal = limitBal;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public int getMarriage() {
        return marriage;
    }

    public void setMarriage(int marriage) {
        this.marriage = marriage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPay0() {
        return pay0;
    }

    public void setPay0(int pay0) {
        this.pay0 = pay0;
    }

    public int getPay2() {
        return pay2;
    }

    public void setPay2(int pay2) {
        this.pay2 = pay2;
    }

    public int getPay3() {
        return pay3;
    }

    public void setPay3(int pay3) {
        this.pay3 = pay3;
    }

    public int getPay4() {
        return pay4;
    }

    public void setPay4(int pay4) {
        this.pay4 = pay4;
    }

    public int getPay5() {
        return pay5;
    }

    public void setPay5(int pay5) {
        this.pay5 = pay5;
    }

    public int getPay6() {
        return pay6;
    }

    public void setPay6(int pay6) {
        this.pay6 = pay6;
    }

    public double getBill1() {
        return bill1;
    }

    public void setBill1(double bill1) {
        this.bill1 = bill1;
    }

    public double getBill2() {
        return bill2;
    }

    public void setBill2(double bill2) {
        this.bill2 = bill2;
    }

    public double getBill3() {
        return bill3;
    }

    public void setBill3(double bill3) {
        this.bill3 = bill3;
    }

    public double getBill4() {
        return bill4;
    }

    public void setBill4(double bill4) {
        this.bill4 = bill4;
    }

    public double getBill5() {
        return bill5;
    }

    public void setBill5(double bill5) {
        this.bill5 = bill5;
    }

    public double getBill6() {
        return bill6;
    }

    public void setBill6(double bill6) {
        this.bill6 = bill6;
    }

    public double getPayCurrent1() {
        return payCurrent1;
    }

    public void setPayCurrent1(double payCurrent1) {
        this.payCurrent1 = payCurrent1;
    }

    public double getPayCurrent2() {
        return payCurrent2;
    }

    public void setPayCurrent2(double payCurrent2) {
        this.payCurrent2 = payCurrent2;
    }

    public double getPayCurrent3() {
        return payCurrent3;
    }

    public void setPayCurrent3(double payCurrent3) {
        this.payCurrent3 = payCurrent3;
    }

    public double getPayCurrent4() {
        return payCurrent4;
    }

    public void setPayCurrent4(double payCurrent4) {
        this.payCurrent4 = payCurrent4;
    }

    public double getPayCurrent5() {
        return payCurrent5;
    }

    public void setPayCurrent5(double payCurrent5) {
        this.payCurrent5 = payCurrent5;
    }

    public double getPayCurrent6() {
        return payCurrent6;
    }

    public void setPayCurrent6(double payCurrent6) {
        this.payCurrent6 = payCurrent6;
    }

    public int getDefaultPaymentNextMonth() {
        return defaultPaymentNextMonth;
    }

    public void setDefaultPaymentNextMonth(int defaultPaymentNextMonth) {
        this.defaultPaymentNextMonth = defaultPaymentNextMonth;
    }

    
    
    private boolean validarMontoAPagar(){
        return !(payCurrent1 <= 0 || payCurrent2 <= 0 || payCurrent3 <= 0 || payCurrent4 <= 0 || payCurrent5 <= 0 || payCurrent6 <= 0); 
    }

    private boolean validarMontoPagado(){
        return !(bill1 <= 0 || bill2 <= 0 || bill3 <= 0 || bill4 <= 0 || bill5 <= 0 || bill6 <= 0); 
    }

    public boolean validarMontoHistorialPagos() {
        return validarMontoAPagar() && validarMontoPagado();
    }

    @Override
    public String toString() {
        return "HistorialPagos{" + "id=" + id + ", limitBal=" + limitBal + ", sex=" + sex + ", education=" + education + ", marriage=" + marriage + ", age=" + age + ", pay0=" + pay0 + ", pay2=" + pay2 + ", pay3=" + pay3 + ", pay4=" + pay4 + ", pay5=" + pay5 + ", pay6=" + pay6 + ", bill1=" + bill1 + ", bill2=" + bill2 + ", bill3=" + bill3 + ", bill4=" + bill4 + ", bill5=" + bill5 + ", bill6=" + bill6 + ", payCurrent1=" + payCurrent1 + ", payCurrent2=" + payCurrent2 + ", payCurrent3=" + payCurrent3 + ", payCurrent4=" + payCurrent4 + ", payCurrent5=" + payCurrent5 + ", payCurrent6=" + payCurrent6 + ", defaultPaymentNextMonth=" + defaultPaymentNextMonth + '}';
    }
    
    
}
