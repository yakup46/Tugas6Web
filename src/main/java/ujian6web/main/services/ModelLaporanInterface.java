package ujian6web.main.services;

import java.util.List;

import ujian6web.main.entity.Laporan;


public interface ModelLaporanInterface {
	
	public List<Laporan> getAllLaporan();
	public Laporan getLaporanByNama(String nama);
	
	public Laporan addLaporan(Laporan laporan);
	public Laporan getLaporanById(String id);
	public void deleteLaporan(String id);
	
}
