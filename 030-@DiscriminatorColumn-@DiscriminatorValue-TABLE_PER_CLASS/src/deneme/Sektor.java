package deneme;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="SEKTOR")  // Sektor dtype -> SEKTÖR olarak Deðiþtirdik
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
