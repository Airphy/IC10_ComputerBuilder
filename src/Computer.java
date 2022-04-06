import java.text.NumberFormat;

public class Computer { // outer class

    private CPU mCPU;
    private RAM mRAM;
    private Storage mStorage;
    private VideoCard mVideoCard;
    private NumberFormat currency = NumberFormat.getCurrencyInstance();

    public CPU getCPU() {
        return mCPU;
    }

    public RAM getRAM() {
        return mRAM;
    }

    public Storage getStorage() {
        return mStorage;
    }

    public VideoCard getVideoCard() {
        return mVideoCard;
    }

    public double calculateCost()
    {
        // Add all the prices of the parts
        double total = 0.0;
        if(mCPU != null)
            total += mCPU.mPrice;
        if(mRAM != null)
            total += mRAM.mPrice;
        if(mStorage != null)
            total += mStorage.mPrice;
        if(mVideoCard != null)
            total += mVideoCard.mPrice;

        return total;


    }

    @Override
    public String toString() {

        return  "---Computer Specifications---\n" +
                mCPU + " \n" +
                mRAM +" \n" +
                mStorage + " \n" +
                mVideoCard + " \n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Total Cost as Configured: "+ currency.format(calculateCost());
    }

    // Nested Inner Classes

     class CPU {

    private String mManufacturer, mCore;
    private double mPrice, mSpeed;



         public CPU(String manufacturer, String core, double speed, double price) {
             mManufacturer = manufacturer;
             mCore = core;
             mPrice = price;
             mSpeed = speed;
             mCPU = this;
         }

         @Override
         public String toString() {
             return "CPU["
                     + mManufacturer + " "
                     + mCore + " "
                     + mSpeed + "GHz "
                     + currency.format(mPrice)
                     + ']';
         }
     }

     class RAM {

         private String mManufacturer;
         private double mPrice, mSpeed, mCapacity;

         public RAM(String manufacturer, double price, double speed, double capacity) {
             mManufacturer = manufacturer;
             mPrice = price;
             mSpeed = speed;
             mCapacity = capacity;
             mRAM = this;
         }

         @Override
         public String toString() {
             return "RAM["
                     + mManufacturer + " "
                     + mCapacity + " GB "
                     + mSpeed + "MHz "
                     + currency.format(mPrice)
                     + ']';
         }
     }

     class Storage {

         private String mManufacturer, mType;
         private double mPrice, mCapacity;

         public Storage(String manufacturer, String type, double price, double capacity) {
             mManufacturer = manufacturer;
             mType = type;
             mPrice = price;
             mCapacity = capacity;
             mStorage = this;
         }

         @Override
         public String toString() {
             return "Storage["
                     + mManufacturer + " "
                     + mCapacity + " TB "
                     + mType + " "
                     + currency.format(mPrice)
                     + ']';
         }
     }

     class VideoCard {

         private String mManufacturer, mMaxRes;
         private double mPrice, mCapacity;

         public VideoCard(String manufacturer, String maxRes, double price, double capacity) {
             mManufacturer = manufacturer;
             mMaxRes = maxRes;
             mPrice = price;
             mCapacity = capacity;
             mVideoCard = this;
         }

         @Override
         public String toString() {
             return "VideoCard["
                     + mManufacturer + " "
                     + mCapacity + " "
                     + mMaxRes + " pixels "
                     + currency.format(mPrice)
                     + ']';
         }
     }
}
