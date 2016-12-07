/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import ui.SellerView;

/**
 *
 * @author Spinal
 */
public class InventoryListener implements ChangeListener
{
    public InventoryListener( SellerView sellerView) 
    {
        this.sv = sellerView;
    }
    
    @Override
    public void stateChanged(ChangeEvent ev)
    {
        //sv.updateInventoryView(null, sv);
    }

    
    private SellerView sv;
}
