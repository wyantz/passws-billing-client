/**
 * 
 */
package pass.billing.client.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.pass.billing.wsclient.GetTagihanResponse;
import com.pass.billing.wsclient.ItemTagihan;
import com.pass.billing.wsclient.PDAM;
import com.pass.billing.wsclient.PeriodeRekening;
import com.pass.billing.wsclient.Tagihan;
import com.pass.billing.wsclient.Tagihan.Items;

import pass.billing.client.BillingPASSWSClient;
import pass.billing.client.BillingPASSWSClientFactory;

/**
 * @author Awiyanto Ajisasongko
 *
 */
public class WSTest {
	private Log log = LogFactory.getLog(getClass());

	//@Test
	public void testListPDAM() throws Exception {
		log.debug("**************************************");
		log.debug("             listPDAM");
		log.debug("**************************************");
		BillingPASSWSClient gateway = BillingPASSWSClientFactory.getInstance("https://localhost:8443/passws/billing", "demomitra", "5a1549fc8293b19d659a4759ce0b2806");
		
		
		Collection<PDAM> result = gateway.listPDAM();
		for (PDAM p : result) {
			log.debug("kode: "+p.getKodePDAM()+", nama:"+p.getNama());			
		}
		
		
		GetTagihanResponse response = gateway.getTagihan("006-32580", "010300241505");
		if (response!=null) {
			int jumlahRekening = response.getJumlahRekening();
			log.debug("Nama Pelanggan:"+response.getNama());
			log.debug("Alamat:"+response.getAlamat());
			log.debug("Jumlah Total:"+response.getTotalTagihan());
			log.debug("Jumlah Denda (Total):"+response.getTotalDenda());
			log.debug("Grand Total:"+response.getGrandTotal());
			
			log.debug("Detail Tagihan:");
			for (int i=0; i<jumlahRekening; i++) {
				Tagihan tagihan = response.getTagihan().get(i);
				log.debug("Periode:"+tagihan.getPeriode());
				Items items = tagihan.getItems();
				for (ItemTagihan it : items.getItem()) {
					log.debug("\tnamaItem:"+it.getNamaItem()+", jumlah:"+it.getJumlah());
				}
			}
		}
	}

	//@Test
	public void testBayar() throws Exception {
		log.debug("**************************************");
		log.debug("            bayarTagihan");
		log.debug("**************************************");
		BillingPASSWSClient gateway = BillingPASSWSClientFactory.getInstance("https://localhost:8443/passws/billing", "demomitra", "5a1549fc8293b19d659a4759ce0b2806");
		
		Collection<PeriodeRekening> periode = new ArrayList<>();
		PeriodeRekening pr = new PeriodeRekening();
		pr.setPeriode("201412");
		pr.setSubtotal(new BigDecimal("69474"));
		periode.add(pr);
		
		gateway.bayarTagihan("006-32580", "010300241505", periode, 69474, "LKT-TEST", "1234567890");
	}

	//@Test
	public void testBatalBayar() throws Exception {
		log.debug("**************************************");
		log.debug("             batalBayar");
		log.debug("**************************************");
		BillingPASSWSClient gateway = BillingPASSWSClientFactory.getInstance("https://localhost:8443/passws/billing", "demomitra", "5a1549fc8293b19d659a4759ce0b2806");
		
		Collection<String> periode = new ArrayList<>();
		periode.add("201412");
		gateway.batalBayar("006-32580", "010300241505", "Test", periode);
	}
	
	//@Test
	public void testGetLPP() throws Exception {
		log.debug("**************************************");
		log.debug("              getLPP");
		log.debug("**************************************");
		BillingPASSWSClient gateway = BillingPASSWSClientFactory.getInstance("https://localhost:8443/passws/billing", "demomitra", "5a1549fc8293b19d659a4759ce0b2806");
		String generatedFile = gateway.getLPP("006-32580", "2018-06-27", "D:/tmp/unzipTest");
		log.debug(generatedFile);
	}
	
	@Test
	public void testKirimFileRekon() throws Exception {
		log.debug("**************************************");
		log.debug("              postRekon");
		log.debug("**************************************");
		BillingPASSWSClient gateway = BillingPASSWSClientFactory.getInstance("https://localhost:8443/passws/billing", "demomitra", "5a1549fc8293b19d659a4759ce0b2806");
		gateway.postRekon("006-32580", "2018-06-27", "/tmp/REKON-POS.csv");
	}
}
