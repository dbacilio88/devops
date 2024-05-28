import { Mapper, MappingProfile, createMap } from "@automapper/core";
import { AutomapperProfile, InjectMapper } from "@automapper/nestjs";
import { Injectable } from "@nestjs/common";
import { SpecialtyDocument } from "src/api/documents/Specialty.document";
import { SpecialtyDto } from "src/dtos/Specialty.dto";


@Injectable()
export class SpecialtyProfile extends AutomapperProfile {

    constructor(@InjectMapper() mapper: Mapper) {
        super(mapper);
    }

    get profile(): MappingProfile {
        return (mapper: Mapper) => {
            createMap(mapper, SpecialtyDocument, SpecialtyDto)
            createMap(mapper, SpecialtyDto, SpecialtyDocument)
        }
    }
}