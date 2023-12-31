package pc01815.Normal_J6.Entity;
// Generated Jul 17, 2022, 5:56:00 PM by Hibernate Tools 4.3.6.Final

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Server.ServerRequest;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.ToString;

/**
 * Category generated by hbm2java
 */
@Data
@Entity
@ToString
@Table(name = "category", catalog = "normal_j6")

public class Category implements java.io.Serializable {

	private Integer id;
	@NotEmpty(message = "Không được để trống tên category")
	private String name;
	private List<Products> productses = new ArrayList<Products>();

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public Category(String name, List<Products> productses) {
		this.name = name;
		this.productses = productses;
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

	@Column(name = "name", nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@JsonBackReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	public List<Products> getProductses() {
		return this.productses;
	}

	public void setProductses(List<Products> productses) {
		this.productses = productses;
	}


}
