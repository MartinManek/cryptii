package cz.manek.cryptii.ciphers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CipherDO {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(unique = true)
    private String name;

    @ElementCollection
    @MapKeyColumn(name="key")
    @Column(name="value")
    @CollectionTable(name="encodingTable", joinColumns=@JoinColumn(name="ciphre_id"))
    private Map<Character, String> encodingTable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Character, String> getEncodingTable() {
        return encodingTable;
    }

    public void setEncodingTable(Map<Character, String> encodingTable) {
        this.encodingTable = encodingTable;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof CipherDO))
            return false;
        CipherDO cipher = (CipherDO) o;
        return Objects.equals(this.id, cipher.id) && Objects.equals(this.name, cipher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }
}
