package HeMaSeaFoodSystem;

public class SeaFoodItem {

    //The name of the food
    private final String foodName;

    //The id for this product
    private final String itemId;

    //The PackageSize of this food
    private final FoodPackSize packSize;

    //The produced time
    private final long produceTime;

    //The expired time
    private long expiredTime;

    //The field to put extra information
    private final Map<String, Object> extraInfo;

    /**
     * Constructor
     * @para    foodName    The name of this food
     * @param   itemId      the id for this product
     *
     */
    public SeaFoodItem(@NotNull final String foodName, @NotNull final String itemId,
                       @NotNull final FoodPackSize packSize, @NotNull final long produceTime,
                       Map<String, Object> extraInfo) {
        this.foodName = foodName;
        this.itemId = itemId;
        this.produceTime = produceTime;
        this.extraInfo = extraInfo;
    }
}
