import java.util.LinkedList;
import java.util.List;

public class Inventory{
    private List<Instrument> inventory;

    public Inventory(){
        this.inventory = new LinkedList<Instrument>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec){
        Instrument instrument = null;

        if(spec instanceof GuitarSpec){
            instrument = new Guitar(serialNumber, price, (GuitarSpec)spec);
        }
        else if(spec instanceof MandolinSpec){
            instrument = new Mandolin(serialNumber, price, (MandolinSpec)spec);
        }

        this.inventory.add(instrument);
    }

    public Instrument getInstrument(String serialNumber){
        for(Instrument instrument : this.inventory){
            if(instrument.getSerialNumber().equals(serialNumber)){
                return instrument;
            }
        }

        return null;
    }

    public List<Guitar> search(GuitarSpec searchSpec){
        List<Guitar> matchingGuitars = new LinkedList<Guitar>();

        for(Instrument instrument : inventory){
            if(instrument instanceof Guitar){
                Guitar guitar = (Guitar)instrument;

                if(guitar.getSpec().matches(searchSpec)){
                    matchingGuitars.add(guitar);
                }
            }
        }

        return matchingGuitars;
    }

    public List<Mandolin> search(MandolinSpec searchSpec){
        List<Mandolin> matchingMandolins = new LinkedList<Mandolin>();

        for(Instrument instrument : inventory){
            if(instrument instanceof Mandolin){
                Mandolin mandolin = (Mandolin)instrument;

                if(mandolin.getSpec().matches(searchSpec)){
                    matchingMandolins.add(mandolin);
                }
            }
        }

        return matchingMandolins;
    }

    // private List guitars;
    
    // public Inventory(){
    //     guitars = new LinkedList();
    // }
    
    // public void addGuitar(String serialNumber, double price, GuitarSpec spec){
    //     Guitar guitar = new Guitar(serialNumber, price, spec);
    //     guitars.add(guitar);   
    // }
    
    // public Guitar getGuitar(String serialNumber){
    //     for (Iterator i = guitars.iterator(); i.hasNext();){
    //         Guitar guitar = (Guitar)i.next();
            
    //         if (guitar.getSerialNumber().equals(serialNumber)){
    //             return guitar;
    //         }
    //     }
    //     return null;
    // }
    
    // public List search(GuitarSpec searchSpec){
    //     List matchingGuitars = new LinkedList();
        
    //     for (Iterator i = guitars.iterator(); i.hasNext();){
    //         Guitar guitar = (Guitar)i.next();
            
    //         if (guitar.getSpec().matches(searchSpec)){
    //            matchingGuitars.add(guitar); 
    //         }
    //     }
    //     return matchingGuitars;
    // }    
}