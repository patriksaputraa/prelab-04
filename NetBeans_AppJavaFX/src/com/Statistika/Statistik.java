package com.Statistika;

public class Statistik {
    private double[] data;
    private int cacah;
    int size;

    Statistik(int length){
        this.size = length;
        data = new double[length];
        this.cacah = 0;
    }

    public void growSize(){
        double temp[] = null;
        if(cacah==data.length){
            temp = new double[data.length+1];
            for(int i=0;i<data.length;i++){
                temp[i] = data[i];
            }
        }
        size++;
        data=temp;
    }

    public void decreaseSize(){
        double temp[] = null;
        if(cacah==data.length){
            temp = new double[data.length-1];
            for(int i=0;i<data.length;i++){
                temp[i] = data[i];
            }
        }
        size--;
        data=temp;
    }

    public int getCacah(){
        return this.cacah;
    }

    void addData(double elemen){
        if(cacah==data.length){
            growSize();
        }
        data[cacah] = elemen;
        cacah++;
    }

    void deleteData(){
        cacah--;
        double temp[] = null;
        temp = new double[data.length - 1];
        for (int i = 0; i < data.length-1; i++) {
            temp[i] = data[i];
        }
        size--;
        data=temp;
    }

    public double sum(){
        double sum = 0;
        for(int i=0;i<cacah;i++){
            sum+=this.data[i];
        }
        return sum;
    }

    public double average(){
        double rerata = this.sum()/this.cacah;
        return rerata;
    }

    public String getData(){
        String data_list = "";
        for(int i=0;i<data.length;i++){
            data_list = data_list + data[i] + "  ";
        }
        return data_list;
    }

    public double minimum(){
        double min = data[0];
        for(int i=0;i<data.length;i++){
            if(data[i]<min){
                min = data[i];
            }
        }
        return min;
    }

    public double maximum(){
        double max = data[0];
        for(int i=0;i<data.length;i++){
            if(data[i]>max){
                max = data[i];
            }
        }
        return max;
    }
}


