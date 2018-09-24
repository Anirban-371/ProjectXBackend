package com.projectX.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Roles")
public class Roles {
	
	public static final String ADMIN = "admin";

    public static final String NAMESPACE = "roles";

    @Id
    private int id;

    @NotBlank
    private String name;

    private Set<Permissions> permissions;

    public  Roles()
    {
    }

    public  Roles( final String name, final Permissions... perms )
    {
        this.name = name;
        this.permissions = new HashSet<Permissions>( Arrays.asList( perms ) );
    }

    public  Roles( final String name, final Collection<Permissions> perms )
    {
        this.name = name;
        this.permissions = new HashSet<Permissions>( perms );
    }

    public  int getId()
    {
        return id;
    }

    public  void setId( final int id )
    {
        this.id = id;
    }

    public  String getName()
    {
        return name;
    }

    public  void setName( final String name )
    {
        this.name = name;
    }

    public synchronized  void addPermission( final Permissions permission )
    {
        if ( permissions == null )
        {
            permissions = new HashSet<Permissions>();
        }
        permissions.add( permission );
    }

    public  void removePermission( final Permissions permission )
    {
        if ( permissions != null )
        {
            permissions.remove( permission );
        }
    }

    public  Set<Permissions> getPermissions()
    {
        return permissions;
    }

    public  void setPermissions( final Set<Permissions> permissions )
    {
        this.permissions = permissions;
    }

    @Override
    public  int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public  boolean equals( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass() != obj.getClass() )
        {
            return false;
        }
        final Roles other = (Roles) obj;
        if ( !name.equals( other.name ) )
        {
            return false;
        }
        return true;
    }

    public  Roles updateFrom( final Roles role )
    {
        this.permissions = role.getPermissions();
        return this;
    }
}
