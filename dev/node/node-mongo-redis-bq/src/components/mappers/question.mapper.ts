
import { Mapper } from "@automapper/core";
import { InjectMapper } from "@automapper/nestjs";
import { Injectable } from "@nestjs/common";
import { MapperBase } from "../base/mapper.base";
import { QuestionDocument } from "src/api/documents/Question.document";
import { QuestionDto } from "src/dtos/Question.dto";

@Injectable()
export class QuestionMapper extends MapperBase<QuestionDocument, QuestionDto> {

    constructor(@InjectMapper() private mapper: Mapper) {
        super(mapper);
    }


    override  mapToDtoAsync(entity: QuestionDocument): Promise<QuestionDto> {
        return this.mapper.mapAsync<QuestionDocument, QuestionDto>(entity, QuestionDocument, QuestionDto);
    }

    override mapToEntityAsync(dto: QuestionDto): Promise<QuestionDocument> {
        return this.mapper.mapAsync<QuestionDto, QuestionDocument>(dto, QuestionDto, QuestionDocument);
    }

    override mapToDtosAsync(entities: QuestionDocument[]): Promise<QuestionDto[]> {
        const dtos = this.mapper.mapArrayAsync<QuestionDocument, QuestionDto>(entities, QuestionDocument, QuestionDto);
        return dtos;
    }

    override mapToEntitiesAsync(dtos: QuestionDto[]): Promise<QuestionDocument[]> {
        return this.mapper.mapArrayAsync<QuestionDto, QuestionDocument>(dtos, QuestionDto, QuestionDocument);
    }

    override  mapToDto(entity: QuestionDocument): QuestionDto {
        return this.mapper.map<QuestionDocument, QuestionDto>(entity, QuestionDocument, QuestionDto);
    }

    override mapToEntity(dto: QuestionDto): QuestionDocument {
        return this.mapper.map<QuestionDto, QuestionDocument>(dto, QuestionDto, QuestionDocument);
    }

    override mapToDtos(entities: QuestionDocument[]): QuestionDto[] {
        const dtos = this.mapper.mapArray<QuestionDocument, QuestionDto>(entities, QuestionDocument, QuestionDto);
        return dtos;
    }

    override mapToEntities(dtos: QuestionDto[]): QuestionDocument[] {
        return this.mapper.mapArray<QuestionDto, QuestionDocument>(dtos, QuestionDto, QuestionDocument);
    }
}