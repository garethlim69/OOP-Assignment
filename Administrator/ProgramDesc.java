/*
 This class is used to store the details of all self-awareness program
 ----- Public users can see the details using "public" methods "get()"
 ----- Admin can edit the details using "protected" methods "setDetail()"
 */
package Administrator;

import javax.swing.JOptionPane;

public class ProgramDesc 
{
    // These are the default details of the programs
    private String publicTransportDesc = "Desc 1";
    private String foodWasteDesc = "Desc 2";
    private String energyDesc = "Desc 3";
    private String plantTreeDesc = "Desc 4";


    /*
    --- get() methods are used to read the data
    --- set() methods are used to edit the data
     */
    public String getPublicTransportDesc() {
        return publicTransportDesc;
    }
    protected void setPublicTransportDesc(String publicTransportDesc) {
        this.publicTransportDesc = publicTransportDesc;
    }

    public String getFoodWasteDesc() {
        return foodWasteDesc;
    }
    protected void setFoodWasteDesc(String foodWasteDesc) {
        this.foodWasteDesc = foodWasteDesc;
    }

    public String getEnergyDesc() {
        return energyDesc;
    }
    protected void setEnergyDesc(String energyDesc) {
        this.energyDesc = energyDesc;
    }
    
    public String getPlantTreeDesc() {
        return plantTreeDesc;
    }
    protected void setPlantTreeDesc(String plantTreeDesc) {
        this.plantTreeDesc = plantTreeDesc;
    }


    // This protected method can only be used by Admin
    // It is used to edit the program detail
    protected void setDetail(int programNum)
    {
        // As the admin choose the program num, the respective program will be accessed by Admin for the editing process
        switch(programNum)
        {
            case 1:
                ProgramDesc p1 = new ProgramDesc();
                String content = JOptionPane.showInputDialog("Edit the program details",p1.getPublicTransportDesc());

                p1.setPublicTransportDesc(content);
                break;

            case 2:
                ProgramDesc p2 = new ProgramDesc();
                String content2 = JOptionPane.showInputDialog("Edit the program details",p2.getFoodWasteDesc());

                p2.setFoodWasteDesc(content2);
                break;

            case 3:
                ProgramDesc p3 = new ProgramDesc();
                String content3 = JOptionPane.showInputDialog("Edit the program details",p3.getEnergyDesc());

                p3.setEnergyDesc(content3);
                break;

            case 4:
                ProgramDesc p4 = new ProgramDesc();
                String content4 = JOptionPane.showInputDialog("Edit the program details",p4.getPlantTreeDesc());

                p4.setPlantTreeDesc(content4);
                break;

        }
    }
    /////////////////////////////////////////////////

    
}
