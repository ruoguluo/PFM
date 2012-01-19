dataSource {
	pooled = false
	driverClassName = "com.mysql.jdbc.Driver"
	username = "pfm"
	password = "pfm"
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource {
			pooled = true
			driverClassName = "org.hsqldb.jdbcDriver"
			username = "sa"
			password = ""
			dbCreate = "create-drop" // one of 'create', 'create-drop','update'
            url = "jdbc:hsqldb:mem:devDB"
		}
	}
	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:mysql://localhost:3306/PFM"
		}
	}
	production {
		dataSource {
			dbCreate = "update"
			url = "jdbc:mysql://localhost:3306/PFM"
		}
	}
}
