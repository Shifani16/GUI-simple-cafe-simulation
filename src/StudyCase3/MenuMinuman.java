/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudyCase3;

/**
 *
 * @author ASUS
 */
public class MenuMinuman extends Menu {
    private String customType;

    public MenuMinuman(String IDMenu, String namaMenu, double hargaMenu, String customType) {
        super(IDMenu, namaMenu, hargaMenu);
        this.customType = customType;
    }
    public void setCustomType(String customType) {
        this.customType = customType;
    }
    
    public String getCustomType() {
        return customType;
    }

}
