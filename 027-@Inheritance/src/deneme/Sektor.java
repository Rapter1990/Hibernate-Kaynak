package deneme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SEKTOR")
public class Sektor extends Meslek{

	@Column(name="CALISMA_ALANI")
	private String calismaAlani;

	public String getCalismaAlani() {
		return calismaAlani;
	}

	public void setCalismaAlani(String calismaAlani) {
		this.calismaAlani = calismaAlani;
	}
	
	
}
