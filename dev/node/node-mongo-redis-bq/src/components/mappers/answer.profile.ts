import { Mapper, MappingProfile, createMap } from "@automapper/core";
import { AutomapperProfile, InjectMapper } from "@automapper/nestjs";
import { Injectable } from "@nestjs/common";
import { AnswerDocument } from "src/api/documents/Answer.document";
import { AnswerDto } from "src/dtos/Answer.dto";


@Injectable()
export class AnswerProfile extends AutomapperProfile {

    constructor(@InjectMapper() mapper: Mapper) {
        super(mapper);
    }

    get profile(): MappingProfile {
        return (mapper: Mapper) => {
            createMap(mapper, AnswerDocument, AnswerDto)
            createMap(mapper, AnswerDto, AnswerDocument)
        }
    }
}