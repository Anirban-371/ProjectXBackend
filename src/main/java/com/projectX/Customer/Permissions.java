package com.projectX.Customer;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import static org.apache.commons.lang.StringUtils.join;


@Document(collection = "Permissions")
public class Permissions implements org.apache.shiro.authz.Permission {
	
	@Id
	private String id;
	private String name;
	private String description;
	
	public static enum permissionList{
		READ , WRITE, CREATE, UPDATE, DELETE
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public boolean implies(Permission p) {
		System.out.println(this);
		System.out.println(p);
		WildcardPermission w= new WildcardPermission(this.name);
		
		 if ( p instanceof Permission && p.equals(w))
	     {
            return true;
        }
		return false;
	}
	 @Override
	    public  int hashCode()
	    {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result /*+ Integer.parseInt(name)*/;
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
	        
	        final Permissions other = (Permissions) obj;
	        if ( !name.equals( other.name) )
	        {
	            return false;
	        }
	        return true;
	    }

	
	/*public static final String WILDCARD = "*";

    public static final String CREATE = "create";

    public static final String READ = "read";

    public static final String UPDATE = "update";

    public static final String DELETE = "delete";

    public static final String ADMIN = "admin";

    public static final String NAMESPACE = "permissions";

    @Id
    private String name;

    public  Permissions()
    {
    }

    public  Permissions( final String... nameParts )
    {
        this.name = name( nameParts );
    }

    public  String getName()
    {
        return name;
    }

    public  void setName( final String name )
    {
        this.name = name;
    }

    @Override
    public  int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + Integer.parseInt(name);
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
        
        final Permissions other = (Permissions) obj;
        if ( !name.equals( other.name) )
        {
            return false;
        }
        return true;
    }

    @Override
    public  boolean implies( final org.apache.shiro.authz.Permission p )
    {
        if ( name.endsWith( WILDCARD ) && ( p instanceof Permission ) )
        {
            Permissions perm = (Permissions) p;
            String prefix = name.substring( 0, name.length() - WILDCARD.length() );

            String permName = perm.getName();
            return permName.length() > prefix.length() && permName.startsWith( prefix );
        }

        return false;
    }

    public static  String name( final String... parts )
    {
        return join( parts, ":" );
    }*/
}
