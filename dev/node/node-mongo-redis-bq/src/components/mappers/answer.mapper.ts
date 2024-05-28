
import { Mapper } from "@automapper/core";
import { InjectMapper } from "@automapper/nestjs";
import { Injectable } from "@nestjs/common";
import { MapperBase } from "../base/mapper.base";
import { AnswerDocument } from "src/api/documents/Answer.document";
import { AnswerDto } from "src/dtos/Answer.dto";

@Injectable()
export class AnswerMapper extends MapperBase<AnswerDocument, AnswerDto> {

    constructor(@InjectMapper() private mapper: Mapper) {
        super(mapper);
    }


    override  mapToDtoAsync(entity: AnswerDocument): Promise<AnswerDto> {
        return this.mapper.mapAsync<AnswerDocument, AnswerDto>(entity, AnswerDocument, AnswerDto);
    }

    override mapToEntityAsync(dto: AnswerDto): Promise<AnswerDocument> {
        return this.mapper.mapAsync<AnswerDto, AnswerDocument>(dto, AnswerDto, AnswerDocument);
    }

    override mapToDtosAsync(entities: AnswerDocument[]): Promise<AnswerDto[]> {
        const dtos = this.mapper.mapArrayAsync<AnswerDocument, AnswerDto>(entities, AnswerDocument, AnswerDto);
        return dtos;
    }

    override mapToEntitiesAsync(dtos: AnswerDto[]): Promise<AnswerDocument[]> {
        return this.mapper.mapArrayAsync<AnswerDto, AnswerDocument>(dtos, AnswerDto, AnswerDocument);
    }

    override  mapToDto(entity: AnswerDocument): AnswerDto {
        return this.mapper.map<AnswerDocument, AnswerDto>(entity, AnswerDocument, AnswerDto);
    }

    override mapToEntity(dto: AnswerDto): AnswerDocument {
        return this.mapper.map<AnswerDto, AnswerDocument>(dto, AnswerDto, AnswerDocument);
    }

    override mapToDtos(entities: AnswerDocument[]): AnswerDto[] {
        const dtos = this.mapper.mapArray<AnswerDocument, AnswerDto>(entities, AnswerDocument, AnswerDto);
        return dtos;
    }

    override mapToEntities(dtos: AnswerDto[]): AnswerDocument[] {
        return this.mapper.mapArray<AnswerDto, AnswerDocument>(dtos, AnswerDto, AnswerDocument);
    }
}