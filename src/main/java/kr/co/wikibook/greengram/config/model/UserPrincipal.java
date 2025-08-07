package kr.co.wikibook.greengram.config.model;

import kr.co.wikibook.greengram.config.enumcode.model.EnumUserRole;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Getter
public class UserPrincipal implements UserDetails {
    private final Long memberId;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long memberId, List<EnumUserRole> roles) {
        this.memberId = memberId;
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(EnumUserRole role : roles){
            String roleName = String.format("ROLE_%s",role.name());
            log.info("roleName: {}",roleName);
            list.add(new SimpleGrantedAuthority(roleName));
        }
        this.authorities = list;

        //this.authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() { return null; }

    @Override
    public String getUsername() { return null; }
}
