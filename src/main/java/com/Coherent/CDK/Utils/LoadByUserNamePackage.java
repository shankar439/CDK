package com.Coherent.CDK.Utils;

import com.Coherent.CDK.entity.Users;
import com.Coherent.CDK.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class LoadByUserNamePackage {

    @Autowired
    UsersRepo usersRepo;
    public UserDetails loadByEmail(String email) {
        Optional<Users> users = usersRepo.findByEmail(email);
        if(users == null){
            throw new RuntimeException("email not found");
        }
        String otpCode = Integer.toString(users.get().getOtp());
        return new org.springframework.security.core.userdetails.User(users.get().getEmail(),otpCode,getAuthorities());

    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        return list;
    }

}
