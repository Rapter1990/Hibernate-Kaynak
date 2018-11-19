package deneme;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="TECRÜBE")
//@Table(name="TECRUBE")
public class Tecrube extends Sektor {

	@Column(name="DENEYIM_YILI")
	private int deneyimYili;

	public int getDeneyimYili() {
		return deneyimYili;
	}

	public void setDeneyimYili(int deneyimYili) {
		this.deneyimYili = deneyimYili;
	}
	
	
	
}
