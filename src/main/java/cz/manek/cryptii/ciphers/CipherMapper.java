package cz.manek.cryptii.ciphers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import javax.crypto.Cipher;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS )
public interface CipherMapper {

    CipherDO map(CipherDTO source);

    CipherDTO map(CipherDO source);

    List<CipherDTO> map(List<CipherDO> source);



}