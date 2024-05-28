
import { Mapper } from "@automapper/core";
import { InjectMapper } from "@automapper/nestjs";
import { Injectable } from "@nestjs/common";
import { MapperBase } from "../base/mapper.base";
import { SpecialtyDocument } from "src/api/documents/Specialty.document";
import { SpecialtyDto } from "src/dtos/Specialty.dto";

@Injectable()
export class SpecialtyMapper extends MapperBase<SpecialtyDocument, SpecialtyDto> {

    constructor(@InjectMapper() private mapper: Mapper) {
        super(mapper);
    }


    override  mapToDtoAsync(entity: SpecialtyDocument): Promise<SpecialtyDto> {
        return this.mapper.mapAsync<SpecialtyDocument, SpecialtyDto>(entity, SpecialtyDocument, SpecialtyDto);
    }

    override mapToEntityAsync(dto: SpecialtyDto): Promise<SpecialtyDocument> {
        return this.mapper.mapAsync<SpecialtyDto, SpecialtyDocument>(dto, SpecialtyDto, SpecialtyDocument);
    }

    override mapToDtosAsync(entities: SpecialtyDocument[]): Promise<SpecialtyDto[]> {
        const dtos = this.mapper.mapArrayAsync<SpecialtyDocument, SpecialtyDto>(entities, SpecialtyDocument, SpecialtyDto);
        return dtos;
    }

    override mapToEntitiesAsync(dtos: SpecialtyDto[]): Promise<SpecialtyDocument[]> {
        return this.mapper.mapArrayAsync<SpecialtyDto, SpecialtyDocument>(dtos, SpecialtyDto, SpecialtyDocument);
    }

    override  mapToDto(entity: SpecialtyDocument): SpecialtyDto {
        return this.mapper.map<SpecialtyDocument, SpecialtyDto>(entity, SpecialtyDocument, SpecialtyDto);
    }

    override mapToEntity(dto: SpecialtyDto): SpecialtyDocument {
        return this.mapper.map<SpecialtyDto, SpecialtyDocument>(dto, SpecialtyDto, SpecialtyDocument);
    }

    override mapToDtos(entities: SpecialtyDocument[]): SpecialtyDto[] {
        const dtos = this.mapper.mapArray<SpecialtyDocument, SpecialtyDto>(entities, SpecialtyDocument, SpecialtyDto);
        return dtos;
    }

    override mapToEntities(dtos: SpecialtyDto[]): SpecialtyDocument[] {
        return this.mapper.mapArray<SpecialtyDto, SpecialtyDocument>(dtos, SpecialtyDto, SpecialtyDocument);
    }
}