import { Mapper, MappingProfile, createMap } from "@automapper/core";
import { AutomapperProfile, InjectMapper } from "@automapper/nestjs";
import { Injectable } from "@nestjs/common";
import { CategoryDocument } from "src/api/documents/Category.document";
import { CategoryDto } from "src/dtos/Category.dto";


@Injectable()
export class CategoryProfile extends AutomapperProfile {

    constructor(@InjectMapper() mapper: Mapper) {
        super(mapper);
    }

    get profile(): MappingProfile {
        return (mapper: Mapper) => {
            createMap(mapper, CategoryDocument, CategoryDto)
            createMap(mapper, CategoryDto, CategoryDocument)
        }
    }
}