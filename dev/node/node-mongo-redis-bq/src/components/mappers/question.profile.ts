import { Mapper, MappingProfile, createMap } from "@automapper/core";
import { AutomapperProfile, InjectMapper } from "@automapper/nestjs";
import { Injectable } from "@nestjs/common";
import { QuestionDocument } from "src/api/documents/Question.document";
import { QuestionDto } from "src/dtos/Question.dto";


@Injectable()
export class QuestionProfile extends AutomapperProfile {

    constructor(@InjectMapper() mapper: Mapper) {
        super(mapper);
    }

    get profile(): MappingProfile {
        return (mapper: Mapper) => {
            createMap(mapper, QuestionDocument, QuestionDto)
            createMap(mapper, QuestionDto, QuestionDocument)
        }
    }
}