package edu.nju.treasuryArbitrage.model;

import edu.nju.treasuryArbitrage.controller.dataInterface.DataInterface;
import edu.nju.treasuryArbitrage.controller.dataInterface.DataInterfaceFactory;
import edu.nju.treasuryArbitrage.controller.fileIO.FileOperater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class LiveData {
    private static final String FUTURES_CODE_CONFIG_FILE = "config/futures-codes";

    private String[] futuresCodes;
    private ArrayList<ArbDetail> arbDetails = new ArrayList<>();
    private Map<String, ArrayList<ArbBrief>> historyPriceToday
    			= new HashMap<>();
	private ArrayList<ArbGroup> arbGroups = new ArrayList<>();

	private static LiveData self = new LiveData();
	public synchronized static LiveData getInstance() {
		return self;
	}
	
	private LiveData(){
        loadFutureCodes();
        initArbDetails();
	}

    /**
     * load future codes from config file
     */
    private void loadFutureCodes() {
        String codes = FileOperater.read(FUTURES_CODE_CONFIG_FILE);
        futuresCodes = codes.split(" ");
        
        for (int i = 0; i < futuresCodes.length; i++) {
        	futuresCodes[i] = futuresCodes[i].trim();
        }
        
        if (futuresCodes.length != 3) {
            throw new RuntimeException("Error in futures config");
        }
    }

    /**
     * Init arb-details with initial value.
     */
    private void initArbDetails() {
        for (int i = 0; i < futuresCodes.length; i++) {
            arbDetails.add(ArbDetail.nullObject(futuresCodes[i]));
        }
    }

    /**
     * Add the data to arbDetails.
     */
    public void register(ArbDetail arbDetail) {
        String symbol = arbDetail.getSymbol();

        //find the index in arb-details for this arb-detail
        int index = 0;
        for (; index < futuresCodes.length; index++) {
            if (futuresCodes[index].equals(symbol)) {
                break;
            }
        }

        arbDetails.set(index, arbDetail);
    }

    public String[] getFuturesCodes() {
        return futuresCodes;
    }

	public ArrayList<ArbDetail> getArbDetails() {
		return arbDetails;
	}
	
	public double getPresentPrice(String id) {
		for (ArbDetail arb_detail : arbDetails) {
			if (arb_detail.getSymbol().equals(id)) {
				return arb_detail.getPresentPrice();
			}
		}
		return -1;
	}
	
	public ArrayList<ArbGroup> getArbGroups() {
		return arbGroups;
	}

	public void setArbGroups(ArrayList<ArbGroup> arbGroups) {
		this.arbGroups = arbGroups;
	}

    public ArrayList<ArbBrief> getHistoryPrice(String futureCode) {
        DataInterface dataInterface =
                DataInterfaceFactory.getInstance().getDataInterfaceToServer();

        if (!historyPriceToday.containsKey(futureCode)) {
            ArrayList<ArbBrief> history = dataInterface.getPastPriceToday(futureCode);
            historyPriceToday.put(futureCode, history);
        }

        return historyPriceToday.get(futureCode);
    }

    /**
     * Get history price today to draw the line graph.
     *
     * To shorten the time of setting up,
     * we'd better get the history only once here but not
     * get histories everywhere in views.
     * So saving the history data here.
     */
    public ArrayList<ArbBrief> getHistoryPrice(int symbolIndex) {
        String symbol = futuresCodes[symbolIndex];
        return getHistoryPrice(symbol);
    }

}
