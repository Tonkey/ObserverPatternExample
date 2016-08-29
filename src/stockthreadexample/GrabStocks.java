package stockthreadexample;

/**
 *
 * @author Nicklas Molving
 */
public class GrabStocks {
    
    public static void main(String[] args) {
        
        StockGrabber sg = new StockGrabber();
        
        StockObserver observer1 = new StockObserver(sg);
        
        sg.setIBMPrice(197.00);
        sg.setAAPLPrice(677.60);
        sg.setGOOGPrice(676.40);
        
        StockObserver observer2 = new StockObserver(sg);
        
        sg.setIBMPrice(197.00);
        sg.setAAPLPrice(677.60);
        sg.setGOOGPrice(676.40);
        
        sg.unregister(observer1);
        
        sg.setIBMPrice(197.00);
        sg.setAAPLPrice(677.60);
        sg.setGOOGPrice(676.40);
        
        Runnable getIBM = new GetTheStock(sg, 2, "IBM", 197.00);
        Runnable getAAPL = new GetTheStock(sg, 2, "AAPL", 677.60);
        Runnable getGOOG = new GetTheStock(sg, 2, "GOOG", 676.40);
        
        new Thread(getIBM).start();
        new Thread(getAAPL).start();
        new Thread(getGOOG).start();
        
    }
    
}
