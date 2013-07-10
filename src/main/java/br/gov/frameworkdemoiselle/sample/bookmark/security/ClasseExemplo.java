package br.gov.frameworkdemoiselle.sample.bookmark.security;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.RequiredPermission;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.security.SecurityContext;

public class ClasseExemplo { 

    @Inject
    private Credential credential;

    @Inject 
    private SecurityContext context; 

    public void metodo1() { 
        credential.setLogin("usuario1");
        credential.setSenha("123");
        context.login(); 

        // codigo do metodo 

        context.logout(); 
    } 

    @RequiredPermission 
    public void requiredPermissionWithoutDeclaredResourceAndOperation() { 
    } 

    @RequiredPermission(resource = "contact", operation = "insert") 
    public void requiredPermissionWithDeclaredResourceAndOperation() { 
    }
    
    @RequiredRole("simpleRoleName") 
    public void requiredRoleWithSingleRole() { 
    } 

    @RequiredRole({ "firstRole", "secondRole", "thirdRole", "fourthRole", "fifthRole" }) 
    public void requiredRoleWithArrayOfRoles() { 
    } 
}