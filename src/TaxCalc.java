public class TaxCalc {

    public final double INFRASTRUCTURE_LEVY= 150000;
    public final double STAMP_DUTY = 35000;
    public final double FORM_FEES = 20000;
    public final double EXCISE_DUTY = 200000;
    public final double APS_FEE = 300000;
    public final double DPS_FEE = 700000;


    public String vehicleType;
    public double cif;
    public int seatingCapacity;
    public double grossWeight;
    public int engineCapacity;
    public int age;
    public boolean isDriven;


    public void setVehicleDetails(String vehicleType, double cif, int seatingCapacity, double grossWeight,
                                  int engineCapacity, int age, boolean isDriven) {
        this.vehicleType = vehicleType;
        this.cif = cif;
        this.seatingCapacity = seatingCapacity;
        this.grossWeight = grossWeight;
        this.engineCapacity = engineCapacity;
        this.age = age;
        this.isDriven = isDriven;
    }

    public void calculateAmbulanceTaxes() {
        System.out.println("Vehicle Type: Ambulance");
        double il = (age > 10) ? 0.15 * cif : INFRASTRUCTURE_LEVY;
        double totalTax = STAMP_DUTY + FORM_FEES + EXCISE_DUTY + il + DPS_FEE;
        printTotalTaxes(totalTax);
    }

    public void calculateEstateTaxes() {
        System.out.println("Vehicle Type: Estate");
        double id = 0.25 * cif;
        double vat = 0.18 * cif;
        double wht = 0.06 * cif;
        double il = calculateILBasedOnAge();
        double seatingTax = (seatingCapacity > 5) ? (seatingCapacity - 5) * 250000 : 0;
        double weightTax = calculateWeightTax();
        double engineTax = calculateEngineTax(1800);
        double totalTax = id + vat + wht + il + STAMP_DUTY + FORM_FEES + EXCISE_DUTY + APS_FEE + seatingTax + weightTax + engineTax;
        printTotalTaxes(totalTax);
    }

    public void calculateSedanTaxes() {
        System.out.println("Vehicle Type: Sedan");
        double id = 0.25 * cif;
        double vat = 0.18 * cif;
        double wht = 0.06 * cif;
        double il = calculateILBasedOnAge();
        double weightTax = calculateWeightTax();
        double engineTax = calculateEngineTax(2000);
        double totalTax = id + vat + wht + il + STAMP_DUTY + FORM_FEES + EXCISE_DUTY + DPS_FEE + weightTax + engineTax;
        printTotalTaxes(totalTax);
    }

    public void calculateSuvTaxes() {
        System.out.println("Vehicle Type: SUV");
        double id = 0.25 * cif;
        double vat = 0.18 * cif;
        double wht = 0.06 * cif;
        double il = calculateILBasedOnAge();
        double seatingTax = (seatingCapacity > 5) ? (seatingCapacity - 5) * 350000 : 0;
        double totalTax = id + vat + wht + il + STAMP_DUTY + FORM_FEES + EXCISE_DUTY + APS_FEE + seatingTax;
        printTotalTaxes(totalTax);
    }

    public void calculateTrailerTaxes() {
        System.out.println("Vehicle Type: Trailer");
        double id = 0.25 * cif;
        double vat = 0.18 * cif;
        double wht = 0.06 * cif;
        double il = calculateILBasedOnAge();
        double weightTax = calculateWeightTax();
        double engineTax = calculateEngineTax(20000);
        double totalTax = id + vat + wht + il + STAMP_DUTY + FORM_FEES + EXCISE_DUTY + APS_FEE + weightTax + engineTax;
        printTotalTaxes(totalTax);
    }

    public void calculateStandardVehicleTaxes() {
        System.out.println("Vehicle Type: Standard Vehicle");
        double id = 0.25 * cif;
        double vat = 0.18 * cif;
        double wht = 0.06 * cif;
        double totalTax = id + vat + wht + INFRASTRUCTURE_LEVY + STAMP_DUTY + FORM_FEES + EXCISE_DUTY + APS_FEE;
        printTotalTaxes(totalTax);
    }

    public void calculateTransportationAndBondFees(int daysInBond) {
        double transportFee = isDriven ? 0.015 * cif : 0.005 * cif;
        double bondFee = daysInBond * 15000;
        System.out.println("Transportation Fee: " + transportFee);
        System.out.println("Bond Parking Fee: " + bondFee);
        System.out.println("Total Extra Fees: " + (transportFee + bondFee));
    }


    public double calculateILBasedOnAge() {
        if (age > 10) return 0.15 * cif;
        else if (age > 5) return 0.05 * cif;
        else if (age > 1) return 0.01 * cif;
        else return INFRASTRUCTURE_LEVY;
    }

    public double calculateWeightTax() {
        if (grossWeight > 2000) return 0.15 * cif;
        else if (grossWeight > 1500) return 0.1 * cif;
        else return 0.02 * cif;
    }

    public double calculateEngineTax(int threshold) {
        if (engineCapacity > threshold) return 0.05 * cif;
        else return 0.025 * cif;
    }

    public void printTotalTaxes(double total) {
        System.out.println("Total Taxes and Fees: " + total);
    }
}
