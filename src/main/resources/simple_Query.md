query {
__schema{
    types{
        name
        }
        }
}


query {
  byTenantName(tenantName:"Sony") {
    processName
    tenantName
  }
}
