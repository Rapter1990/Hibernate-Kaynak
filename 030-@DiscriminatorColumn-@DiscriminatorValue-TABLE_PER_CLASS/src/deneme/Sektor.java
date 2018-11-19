package deneme;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="SEKTOR")  // Sektor dtype -> SEKT�R olarak De�i�tirdik
//@Table(name="SEKTOR")
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
