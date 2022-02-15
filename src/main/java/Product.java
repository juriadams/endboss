public class Product extends ProjectComponent {

    @Override
    public void setProductionCost(float productionCost) {
        if (productionCost <= 0)
            throw new IllegalArgumentException("`productionCost` must be a positive float");

        this.productionCost = productionCost;
    }

    @Override
    public float getProductionCost() {
        return this.productionCost;
    }

}