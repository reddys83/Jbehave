let $identifiers := for $x in collection('source-trusted')/lookup[@fid="THIRD_PARTY_IDENTIFIER_GEO"]/lookupBody/entry
return <identifier>{$x/@id/string()}</identifier>
return <identifiers><identifier></identifier>{$identifiers}</identifiers>