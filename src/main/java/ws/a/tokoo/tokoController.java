/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.tokoo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ws.a.tokoo.exceptions.NonexistentEntityException;

/**
 *
 * @author ERDA WYNE
 */

@Controller
@ResponseBody
public class tokoController {
    
    Barang data = new Barang();
    BarangJpaController actrl = new BarangJpaController();
    
    @RequestMapping(value = "/getName")
    public List<Barang> getAllBarang(){
        
        List<Barang> brg = new ArrayList<Barang>();
        return actrl.findBarangEntities();
        
    }
    
    
      @RequestMapping("delete/{id}")
    public String deleteData(@PathVariable("id") int id){
        try {
            actrl.destroy(id);
            return id + "Delete";
        }
        catch (NonexistentEntityException error) {return id + "Tidak ada";}
    }
    
    
    
    
}
