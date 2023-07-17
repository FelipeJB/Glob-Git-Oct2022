import java.util.HashMap;
//import java.util.Map;

public class Supermarket
{
    private HashMap<String, Float> prices;
    private HashMap<String, String> nameProduct;
    private HashMap<String, Integer> stock;

    public Supermarket() {
        prices = new HashMap<String, Float>();
        nameProduct = new HashMap<String, String>();
        stock = new HashMap<String, Integer>();
    }

    public void addProduct(String code, String name, int amount, float price){
        this.nameProduct.put(code,name);
        this.prices.put(code,price);
        this.stock.put(code,amount);
    }

    public String getName(String code){
        return this.nameProduct.get(code);
    }

    public float getPrice(String code){
        return this.prices.get(code);
    }

    public int getAmount(String code){
        return this.stock.get(code);
    }

    public boolean getCode(String code){
        return this.nameProduct.containsKey(code);
    }

    public boolean isEmpty()
    {
        return this.nameProduct.isEmpty();
    }

    public void listElements(){
        this.nameProduct.forEach((code,value) ->
                System.out.println(code + "|\t" + value + "|\t" + this.prices.get(code) + "|\t"
                        + this.stock.get(code)));
    }

    public void sellProduct(String code, int amount){
        this.stock.replace(code, this.stock.get(code), this.stock.get(code) - amount);
    }

    public void removeProduct(String code) {
        this.nameProduct.remove(code);
        this.stock.remove(code);
        this.prices.remove(code);
    }

/*    public void removeProduct(){
        for(Map.Entry<String, Integer> element : this.stock.entrySet()){
            String code = element.getKey();
            int amount = element.getValue();
            if(amount==0){
                this.nameProduct.remove(code);
                this.stock.remove(code);
                this.prices.remove(code);
            }
        }
        System.out.println("Process completed");
    }*/
}
