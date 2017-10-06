/**
 * 
 */
package pass.billing.client;

import java.math.BigDecimal;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.pass.billing.wsclient.BatalTagihanRequest;
import com.pass.billing.wsclient.BatalTagihanResponse;
import com.pass.billing.wsclient.BayarTagihanRequest;
import com.pass.billing.wsclient.BayarTagihanResponse;
import com.pass.billing.wsclient.GetItemDigunakanRequest;
import com.pass.billing.wsclient.GetItemDigunakanResponse;
import com.pass.billing.wsclient.GetTagihanRequest;
import com.pass.billing.wsclient.GetTagihanResponse;
import com.pass.billing.wsclient.ListNamaItemRequest;
import com.pass.billing.wsclient.ListNamaItemResponse;
import com.pass.billing.wsclient.ListPDAMResponse;
import com.pass.billing.wsclient.NamaItem;
import com.pass.billing.wsclient.ObjectFactory;
import com.pass.billing.wsclient.PDAM;
import com.pass.billing.wsclient.PeriodeRekening;

/**
 * @author Awiyanto Ajisasongko
 *
 */
public class BillingPASSWSClient extends WebServiceGatewaySupport {
	private Log log = LogFactory.getLog(getClass());
	private ObjectFactory factory = new ObjectFactory();
	private String url;

	public BillingPASSWSClient(String url) {
		this.url = url;
	}

	/**
	 * Mengeluarkan daftar PDAM yang dibuka aksesnya
	 * @return Daftar PDAM
	 */
	public Collection<PDAM> listPDAM() {
		ListPDAMResponse response = null;
		try {
			response = (ListPDAMResponse) getWebServiceTemplate().marshalSendAndReceive(url, factory.createListPDAMRequest(null));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (response!=null) return response.getPdamList();
		else return null;
	}
	
	/**
	 * Mengeluarkan daftar seluruh item tagihan baik yang digunakan maupun tidak
	 * @param kodePDAM kode PDAM
	 * @return Nama-nama item tagihan
	 */
	public Collection<NamaItem> listNamaItem(String kodePDAM) {
		ListNamaItemResponse response = null;
		ListNamaItemRequest request = new ListNamaItemRequest();
		request.setKodePDAM(kodePDAM);
		try {
			response = (ListNamaItemResponse) getWebServiceTemplate().marshalSendAndReceive(url, request);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (response!=null) return response.getItem();
		else return null;
	}
	
	/**
	 * Mengeluarkan daftar rekening (tunggakan maupun murni/berjalan)
	 * @param kodePDAM Kode PDAM
	 * @param noSambungan Nomor Sambungan
	 * @return Daftar tagihan
	 */
	public GetTagihanResponse getTagihan(String kodePDAM, String noSambungan) {
		GetTagihanResponse response = null;
		try {
			GetTagihanRequest request = new GetTagihanRequest();
			request.setKodePDAM(kodePDAM);
			request.setNoSambungan(noSambungan);
			
			response = (GetTagihanResponse) getWebServiceTemplate().marshalSendAndReceive(url, request);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return response;
	}
	
	/**
	 * Melakukan pembayaran tagihan
	 * @param kodePDAM Kode PDAM
	 * @param nomorSambungan Nomor Sambungan
	 * @param periode Periode yang akan dibayarkan
	 * @param totalBayar Jumlah total pembayaran (seluruh periode)
	 * @param kodeLoket Kode loket PPOB/Bank
	 * @param nomorReferensi Nomor referensi versi PPOB/Bank
	 * @return Daftar periode yang berhasil dibayarkan berikut nomor referensi nya dengan format [PERIODE]-[NO-REFF]
	 * contoh 201709-41230901212309013212
	 */
	public Collection<String> bayarTagihan(String kodePDAM, String nomorSambungan, Collection<PeriodeRekening> periode, double totalBayar, String kodeLoket, String nomorReferensi) {
		BayarTagihanResponse response = null;
		try {
			BayarTagihanRequest request = new BayarTagihanRequest();
			request.setKodePDAM(kodePDAM);
			request.setKodeLoket(kodeLoket);
			request.setNomorReferensi(nomorReferensi);
			request.setTotalBayar(new BigDecimal(totalBayar));
			request.getPeriodeRekeningDibayar().addAll(periode);
			
			response = (BayarTagihanResponse) getWebServiceTemplate().marshalSendAndReceive(url, request);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		if (response!=null) {
			if (!response.getStatus().equals("000")) throw new RuntimeException("Error code:"+response.getStatus());
			return response.getPeriodeRekeningTerbayar();
		}
		else return null;
	}
	
	/**
	 * Melakukan pembatalan pembayaran tagihan
	 * @param kodePDAM Kode PDAM
	 * @param nomorSambungan Nomor Sambungan
	 * @param alasan Alasan mengapa dibatalkan
	 * @param periode Daftar periode yang dibatalkan pembayarannya
	 * @return Apabila berhasil akan mengembalikan true, sebaliknya false
	 */
	public boolean batalBayar(String kodePDAM, String nomorSambungan, String alasan, Collection<String> periode) {
		BatalTagihanResponse response = null;
		try {
			BatalTagihanRequest request = new BatalTagihanRequest();
			request.setKodePDAM(kodePDAM);
			request.setNoSambungan(nomorSambungan);
			request.setReason(alasan);
			request.getPeriodeDibatalkan().addAll(periode);
			
			response = (BatalTagihanResponse) getWebServiceTemplate().marshalSendAndReceive(url, request);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (response!=null) {
			if (response.getStatus().equals("000")) return true;
		}
		return false;
	}
	
	/**
	 * Daftar nama item yang digunakan oleh suatu PDAM
	 * @param kodePDAM
	 * @return
	 */
	public String[] getItemDigunakan(String kodePDAM) {
		GetItemDigunakanResponse response = null;
		try {
			GetItemDigunakanRequest request = new GetItemDigunakanRequest();
			request.setKodePDAM(kodePDAM);
			
			response = (GetItemDigunakanResponse) getWebServiceTemplate().marshalSendAndReceive(url, request);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (response!=null) return response.getItems().split(",");
		else return null;
	}
}
