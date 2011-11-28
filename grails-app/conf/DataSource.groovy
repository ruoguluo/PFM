dataSource {
    pooled = false
    driverClassName = "com.mysql.jdbc.Driver"
    username = "lrg"
    password = "lrg"
	//dialect= "org.hibernate.dialet.Oracle10gDialect"
	//logSql = true
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
            dbCreate = "update" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://192.168.2.7:3306/GDepot_dev"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:oracle:thin@192.168.2.7:1521:orcl"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:oracle:thin@192.168.2.7:1521:orcl"
        }
    }
}
