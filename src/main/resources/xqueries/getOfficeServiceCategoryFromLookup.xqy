let $serviceCategory := for $x in collection('source-trusted')/lookup[@fid="SERVICE_CATEGORY"]/lookupBody/entry
return <serviceCategory>{$x/@id/string()}</serviceCategory>
return <OfficeService><serviceCategory></serviceCategory>{$serviceCategory}</OfficeService>