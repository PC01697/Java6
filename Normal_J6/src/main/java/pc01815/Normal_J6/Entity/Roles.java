package pc01815.Normal_J6.Entity;
// Generated Jul 17, 2022, 5:56:00 PM by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
@Table(name = "roles", catalog = "normal_j6")
public class Roles implements java.io.Serializable {

	private Integer id;
	private String name;
	private Set<Authorities> authoritieses = new HashSet<Authorities>(0);

	public Roles() {
	}

	public Roles(String name) {
		this.name = name;
	}

	public Roles(String name, Set<Authorities> authoritieses) {
		this.name = name;
		this.authoritieses = authoritieses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	public Set<Authorities> getAuthoritieses() {
		return this.authoritieses;
	}

	public void setAuthoritieses(Set<Authorities> authoritieses) {
		this.authoritieses = authoritieses;
	}

}
